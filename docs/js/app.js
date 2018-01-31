/*jslint es6 */

var global_adapted_json_data = [];
var global_filtered_json_data = [];

var global_problem_id_string = "Id";
var global_problem_name_string = "Name";
var global_problem_link_string = "Link";
var global_problem_origin_string = "Origin";
var global_problem_companies_string = "Companies";
var global_problem_categories_string = "Categories";
var global_problem_tags_string = "Tags";
var global_problem_languages_string = "Languages";


var global_origin = [];
var global_companies = [];
var global_categories = [];
var global_tags = [];
var global_languages = [];
var global_filters_applied = false;

var getJson = new Promise(function (resolve, reject) {
    "use strict";
    //fetch('https://raw.githubusercontent.com/manastalukdar/learning_computer-science/master/docs/problems_list.json', {mode: 'cors'})// uncomment for debugging
    fetch('problems_list.json', {mode: 'no-cors'})
        .then((res) => res.json())
        .then((json_data) => resolve(json_data));
});

//https://stackoverflow.com/a/35318609/420827

function createTable(json_data) {
    "use strict";
    return new Promise(function (resolve, reject) {
        var columnJson = $.map(Object.getOwnPropertyNames(json_data[0]), function (column) {
            return {"name": column,"title": column};
        });

        var count;
        if (json_data.length === 1 && json_data[0].Problem === "") {
            count = 0;
        }
        else {
            count = json_data.length;
        }

        stringifyNestedJsonArrays(json_data)
            .then((nested_arrays_removed_json) => createFooTable(columnJson, nested_arrays_removed_json))
            .then(updateRetrievedCount(count))
            .then(resolve("Success!"));
    });
}

// [
//     {"name":"id","title":"ID","breakpoints":"xs sm","type":"number","style":{"width":80,"maxWidth":80}},
//     {"name":"firstName","title":"First Name"},
//     {"name":"lastName","title":"Last Name"},
//     {"name":"something","title":"Never seen but always around","visible":false,"filterable":false},
//     {"name":"jobTitle","title":"Job Title","breakpoints":"xs sm","style":{"maxWidth":200,"overflow":"hidden","textOverflow":"ellipsis","wordBreak":"keep-all","whiteSpace":"nowrap"}},
//     {"name":"started","title":"Started On","type":"date","breakpoints":"xs sm md","formatString":"MMM YYYY"},
//     {"name":"dob","title":"Date of Birth","type":"date","breakpoints":"xs sm md","formatString":"DD MMM YYYY"},
//     {"name":"status","title":"Status"}
// ]

function stringifyNestedJsonArrays(json_data) {
    "use strict";
    var temp_json_data = JSON.parse(JSON.stringify(json_data));
    return new Promise(function (resolve, reject) {
        temp_json_data.forEach(function (element) {
            var temp;
            if (element.hasOwnProperty(global_problem_companies_string)) {
                temp = element.Companies.join(", ");
                element.Companies = temp;
            }

            if (element.hasOwnProperty(global_problem_categories_string)) {
                temp = element.Categories.join(", ");
                element.Categories = temp;
            }

            if (element.hasOwnProperty(global_problem_tags_string)) {
                temp = element.Tags.join(", ");
                element.Tags = temp;
            }

            if (element.hasOwnProperty(global_problem_languages_string)) {
                temp = element.Languages.join(", ");
                element.Languages = temp;
            }
        });
        resolve(temp_json_data);
    });
}

function adaptJsonData(json_data) {
    "use strict";
    return new Promise(function (resolve, reject) {
        json_data.forEach(function (element) {
            if (global_problem_name_string in element && "Link" in element) {
                var problem_name = element.Name;
                var link = "https://github.com/manastalukdar/learning_computer-science/tree/master/" + element.Link;
                element.Name = "<a href=\"" + link + "\" target=\"_blank\">" + problem_name + "</a>";
                delete element.Link;
            }

            if (element.hasOwnProperty(global_problem_origin_string)) {
                var item = element.Origin;
                if (global_origin.indexOf(item) === -1) {
                    global_origin.push(item);
                }
            }

            var values;
            if (element.hasOwnProperty(global_problem_companies_string)) {
                values = element.Companies;
                values.forEach(function (item) {
                    if (global_companies.indexOf(item) === -1) {
                        global_companies.push(item);
                    }
                });
            }

            if (element.hasOwnProperty(global_problem_categories_string)) {
                values = element.Categories;
                values.forEach(function (item) {
                    if (global_categories.indexOf(item) === -1) {
                        global_categories.push(item);
                    }
                });
            }

            if (element.hasOwnProperty(global_problem_tags_string)) {
                values = element.Tags;
                values.forEach(function (item) {
                    if (global_tags.indexOf(item) === -1) {
                        global_tags.push(item);
                    }
                });
            }

            if (element.hasOwnProperty(global_problem_languages_string)) {
                values = element.Languages;
                values.forEach(function (item) {
                    if (global_languages.indexOf(item) === -1) {
                        global_languages.push(item);
                    }
                });
            }
        });
        global_adapted_json_data = json_data;
        resolve(json_data);
    });
}

function createFooTable(columns, row_data) {
    "use strict";
    return new Promise(function (resolve, reject) {
        $('.table').footable({
            columns: columns,
            rows: row_data
        });
        resolve("Success!");
    });
}

function populateFiltersDropdown() {
    "use strict";
    return new Promise(function (resolve, reject) {
        var items = global_origin.map(function (x) {
            return {item: x};
        });
        $('#input-origin').selectize({
            delimiter: ',',
            persist: false,
            options: items,
            labelField: "item",
            valueField: "item",
            searchField: 'item',
            sortField: 'item'
        });

        items = global_companies.map(function (x) {
            return {item: x};
        });
        $('#input-companies').selectize({
            delimiter: ',',
            persist: false,
            options: items,
            labelField: "item",
            valueField: "item",
            searchField: 'item',
            sortField: 'item'
        });

        items = global_categories.map(function (x) {
            return {item: x};
        });
        $('#input-categories').selectize({
            delimiter: ',',
            persist: false,
            options: items,
            labelField: "item",
            valueField: "item",
            searchField: 'item',
            sortField: 'item'
        });

        items = global_tags.map(function (x) {
            return {item: x};
        });
        $('#input-tags').selectize({
            delimiter: ',',
            persist: false,
            options: items,
            labelField: "item",
            valueField: "item",
            searchField: 'item',
            sortField: 'item'
        });

        items = global_languages.map(function (x) {
            return {item: x};
        });
        $('#input-languages').selectize({
            delimiter: ',',
            persist: false,
            options: items,
            labelField: "item",
            valueField: "item",
            searchField: 'item',
            sortField: 'item'
        });

        var items_temp = ["and", "or"];
        items = items_temp.map(function (x) {
            return {item: x};
        });
        $('#input-and-or-origin-companies').selectize({
            delimiter: ',',
            persist: false,
            options: items,
            labelField: "item",
            valueField: "item",
            searchField: 'item',
            sortField: 'item',
            maxItems: 1
        });
        $('#input-and-or-companies-categories').selectize({
            delimiter: ',',
            persist: false,
            options: items,
            labelField: "item",
            valueField: "item",
            searchField: 'item',
            sortField: 'item',
            maxItems: 1
        });
        $('#input-and-or-categories-tags').selectize({
            delimiter: ',',
            persist: false,
            options: items,
            labelField: "item",
            valueField: "item",
            searchField: 'item',
            sortField: 'item',
            maxItems: 1
        });
        $('#input-and-or-tags-languages').selectize({
            delimiter: ',',
            persist: false,
            options: items,
            labelField: "item",
            valueField: "item",
            searchField: 'item',
            sortField: 'item',
            maxItems: 1
        });
        resolve("Success!");
    });
}

function getFilteredJson() {
    "use strict";
    return new Promise(function (resolve, reject) {
        global_filtered_json_data = [];

        var filter_origins = $('#input-origin').val().split(",");
        var filter_companies = $('#input-companies').val().split(",");
        var filter_categories = $('#input-categories').val().split(",");
        var filter_tags = $('#input-tags').val().split(",");
        var filter_languages = $('#input-languages').val().split(",");

        if (filter_origins.length === 1 && filter_origins[0] === "") {
            filter_origins = [];
        }
        if (filter_companies.length === 1 && filter_companies[0] === "") {
            filter_companies = [];
        }
        if (filter_categories.length === 1 && filter_categories[0] === "") {
            filter_categories = [];
        }
        if (filter_tags.length === 1 && filter_tags[0] === "") {
            filter_tags = [];
        }
        if (filter_languages.length === 1 && filter_languages[0] === "") {
            filter_languages = [];
        }

        var and_or_origin_companies = $('#input-and-or-origin-companies').val();
        var and_or_companies_categories = $('#input-and-or-companies-categories').val();
        var and_or_categories_tags = $('#input-and-or-categories-tags').val();
        var and_or_tags_languages = $('#input-and-or-tags-languages').val();

        var temp_origins = _.filter(global_adapted_json_data, function (item) {
            return isItemInArray(filter_origins, item.Origin);
        });

        var temp_companies = _.filter(global_adapted_json_data, function (item) {
            return isFilterSatisfied(filter_companies, item.Companies);
        });

        var temp_categories = _.filter(global_adapted_json_data, function (item) {
            return isFilterSatisfied(filter_categories, item.Categories);
        });

        var temp_tags = _.filter(global_adapted_json_data, function (item) {
            return isFilterSatisfied(filter_tags, item.Tags);
        });

        var temp_languages = _.filter(global_adapted_json_data, function (item) {
            return isFilterSatisfied(filter_languages, item.Languages);
        });

        var filtered_data = [];
        if (and_or_origin_companies === "and") {
            filtered_data = _.intersectionBy(temp_origins, temp_companies, "Id");
        } else if (and_or_origin_companies === "or") {
            filtered_data = _.unionBy(temp_origins, temp_companies, "Id");
        }

        if (and_or_companies_categories === "and") {
            filtered_data = _.intersectionBy(filtered_data, temp_categories, "Id");
        } else if (and_or_companies_categories === "or") {
            filtered_data = _.unionBy(filtered_data, temp_categories, "Id");
        }

        if (and_or_categories_tags === "and") {
            filtered_data = _.intersectionBy(filtered_data, temp_tags, "Id");
        } else if (and_or_categories_tags === "or") {
            filtered_data = _.unionBy(filtered_data, temp_tags, "Id");
        }

        if (and_or_tags_languages === "and") {
            filtered_data = _.intersectionBy(filtered_data, temp_languages, "Id");
        } else if (and_or_tags_languages === "or") {
            filtered_data = _.unionBy(filtered_data, temp_languages, "Id");
        }

        if (filtered_data.length === 0) {
            filtered_data = [{
                [global_problem_id_string]: "",
                [global_problem_name_string]: "",
                [global_problem_origin_string]: "",
                [global_problem_link_string]: "",
                [global_problem_companies_string]: [],
                [global_problem_categories_string]: [],
                [global_problem_tags_string]: [],
                [global_problem_languages_string]: []
            }];
        }
        global_filtered_json_data = filtered_data;
        resolve(global_filtered_json_data);
    });
}

function applyFilters() {
    "use strict";
    getFilteredJson()
        .then((filtered_json_data) => createTable(filtered_json_data))
        .then(function () {
            global_filters_applied = true;
        });
}

function clearFilters() {
    "use strict";
    if (global_filters_applied) {
        createTable(global_adapted_json_data)
            .then(function () {
                $('#input-origin')[0].selectize.clear();
                $('#input-companies')[0].selectize.clear();
                $('#input-categories')[0].selectize.clear();
                $('#input-tags')[0].selectize.clear();
                $('#input-languages')[0].selectize.clear();
            })
            .then(function () {
                global_filtered_json_data = [];
                global_filters_applied = false;
            });
    }
}

function updateRetrievedCount(count) {
    "use strict";
    $('#retrieved_count').html("Retrieved Count: " + count);
}

function isItemInArray(arr, item) {
    "use strict";
    if (arr.length === 0) {
        return true;
    }
    return (arr.indexOf(item) !== -1);
}

function isFilterSatisfied(filters, items) {
    "use strict";
    if (filters.length === 0 && items.length === 0) {
        return true;
    }
    if (filters.length === 0 && items.length !== 0) {
        return true;
    }
    if (filters.length !== 0 && items.length === 0) {
        return false;
    }
    if (filters.length !== 0 && items.length !== 0) {
        var result = _.intersection(items, filters).length > 0;
        return result;
    }
}

//https://github.com/lodash/lodash/issues/1743#issuecomment-298957228
function arrayContainsArray (superset, subset) {
    "use strict";
    return subset.every(function (value) {
        return (superset.indexOf(value) >= 0);
    });
  }

jQuery(function ($) {
    "use strict";
    getJson
        .then((json_data) => adaptJsonData(json_data))
        .then((changed_json_data) => createTable(changed_json_data))
        .then(function () {
            populateFiltersDropdown();
        });
});

function sleep(ms) {
    "use strict";
    return new Promise((resolve) => setTimeout(resolve, ms));
}