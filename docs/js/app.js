/*jslint es6 */

var adapted_json_data = [];
var filtered_json_data = [];
var origin = [];
var companies = [];
var categories = [];
var tags = [];
var languages = [];
var filters_applied = false;

var getJson = new Promise(function (resolve, reject) {
    "use strict";
    //fetch('https://raw.githubusercontent.com/manastalukdar/learning_computer-science/master/docs/problems_list.json', {mode: 'cors'})// uncomment for debugging
    fetch('problems_list.json', {mode: 'no-cors'})
        .then((res) => res.json())
        .then((json_data) => resolve(json_data));
});

//https://stackoverflow.com/a/35318609/420827

function createTable(adapted_json_data) {
    "use strict";
    return new Promise(function (resolve, reject) {
        var columnJson = $.map(Object.getOwnPropertyNames(adapted_json_data[0]), function (column) {
            return {"name": column,"title": column};
        });

        createFooTable(columnJson, adapted_json_data)
            .then(updateRetrievedCount(adapted_json_data.length))
            .then(resolve("Success!"));
    });
}

function adaptJsonData(json_data) {
    "use strict";
    return new Promise(function (resolve, reject) {
        json_data.forEach(function (element) {
            if ("Problem" in element && "Link" in element) {
                var problem_name = element.Problem;
                var link = "https://github.com/manastalukdar/learning_computer-science/tree/master/" + element.Link;
                element.Problem = "<a href=\"" + link + "\" target=\"_blank\">" + problem_name + "</a>";
                delete element.Link;
            }

            if ("Origin" in element) {
                var item = element.Origin;
                if (origin.indexOf(item) === -1) {
                    origin.push(item);
                }
            }

            if ("Companies" in element) {
                var values = element.Companies;
                values.forEach(function (item) {
                    if (companies.indexOf(item) === -1) {
                        companies.push(item);
                    }
                });
            }

            if ("Categories" in element) {
                values = element.Categories;
                values.forEach(function(item) {
                    if (categories.indexOf(item) === -1) {
                        categories.push(item);
                    }
                });
            }

            if ("Tags" in element) {
                values = element.Tags;
                values.forEach(function(item) {
                    if (tags.indexOf(item) === -1) {
                        tags.push(item);
                    }
                });
            }

            if ("Languages" in element) {
                values = element.Languages;
                values.forEach(function(item) {
                    if (languages.indexOf(item) === -1) {
                        languages.push(item);
                    }
                });
            }
        });
        adapted_json_data = json_data;
        resolve(adapted_json_data);
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
        var items = origin.map(function (x) {
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

        items = companies.map(function (x) {
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

        items = categories.map(function (x) {
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

        items = tags.map(function (x) {
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

        items = languages.map(function (x) {
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
        filtered_json_data = [];

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

        var temp_origins = _.filter(adapted_json_data, function (item) {
            return isItemInArray(filter_origins, item.Origin);
        });

        var temp_companies = _.filter(adapted_json_data, function (item) {
            return isFilterSatisfied(filter_companies, item.Companies);
        });

        var temp_categories = _.filter(adapted_json_data, function (item) {
            return isFilterSatisfied(filter_categories, item.Categories);
        });

        var temp_tags = _.filter(adapted_json_data, function (item) {
            return isFilterSatisfied(filter_tags, item.Tags);
        });

        var temp_languages = _.filter(adapted_json_data, function (item) {
            return isFilterSatisfied(filter_languages, item.Languages);
        });

        var filtered_data = [];
        if (and_or_origin_companies === "and") {
            filtered_data = _.intersectionBy(temp_origins, temp_companies, "Number");
        } else if (and_or_origin_companies === "or") {
            filtered_data = _.unionBy(temp_origins, temp_companies, "Number");
        }

        if (and_or_companies_categories === "and") {
            filtered_data = _.intersectionBy(filtered_data, temp_categories, "Number");
        } else if (and_or_companies_categories === "or") {
            filtered_data = _.unionBy(filtered_data, temp_categories, "Number");
        }

        if (and_or_categories_tags === "and") {
            filtered_data = _.intersectionBy(filtered_data, temp_tags, "Number");
        } else if (and_or_categories_tags === "or") {
            filtered_data = _.unionBy(filtered_data, temp_tags, "Number");
        }

        if (and_or_tags_languages === "and") {
            filtered_data = _.intersectionBy(filtered_data, temp_languages, "Number");
        } else if (and_or_tags_languages === "or") {
            filtered_data = _.unionBy(filtered_data, temp_languages, "Number");
        }

        if (filtered_data.length === 0) {
            filtered_data = [{
                "Number": "",
                "Problem": "",
                "Origin": "",
                "Link": "",
                "Companies": [],
                "Categories": [],
                "Tags": [],
                "Languages": []
            }];
        }
        filtered_json_data = filtered_data;
        resolve(filtered_json_data);
    });
}

function applyFilters() {
    "use strict";
    getFilteredJson()
        .then((filtered_json_data) => createTable(filtered_json_data))
        .then(function () {
            filters_applied = true;
        });
}

function clearFilters() {
    "use strict";
    if (filters_applied) {
        createTable(adapted_json_data)
            .then(function () {
                $('#input-origin')[0].selectize.clear();
                $('#input-companies')[0].selectize.clear();
                $('#input-categories')[0].selectize.clear();
                $('#input-tags')[0].selectize.clear();
                $('#input-languages')[0].selectize.clear();
            })
            .then(function() {
                filtered_json_data = [];
                filters_applied = false;
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
        .then((adapted_json_data) => createTable(adapted_json_data))
        .then(function () {
            populateFiltersDropdown();
        });
});

function sleep(ms) {
    "use strict";
    return new Promise((resolve) => setTimeout(resolve, ms));
}