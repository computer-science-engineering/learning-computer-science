/*jslint es6 */
/*global jQuery */
/*global $ _ fetch this*/
/*jslint browser: true, devel: true */
/*jslint bitwise: true */

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

var global_filter_query_origin_default = "any origin";
var global_filter_query_companies_default = "any origin";
var global_filter_query_categories_default = "any origin";
var global_filter_query_tags_default = "any origin";
var global_filter_query_languages_default = "any origin";
var global_filter_query_and_or_default = "AND";


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

function updateRetrievedCount(count) {
    "use strict";
    $('#retrieved_count').html("Retrieved Count: " + count);
}

function stringifyNestedJsonArrays(json_data) {
    "use strict";
    var temp_json_data = JSON.parse(JSON.stringify(json_data));
    return new Promise(function (resolve, reject) {
        temp_json_data.forEach(function (element) {
            var temp;
            if (element.hasOwnProperty(global_problem_companies_string) && element[global_problem_companies_string] !== "") {
                temp = element.Companies.join(", ");
                element.Companies = temp;
            }

            if (element.hasOwnProperty(global_problem_categories_string) && element[global_problem_categories_string] !== "") {
                temp = element.Categories.join(", ");
                element.Categories = temp;
            }

            if (element.hasOwnProperty(global_problem_tags_string) && element[global_problem_tags_string] !== "") {
                temp = element.Tags.join(", ");
                element.Tags = temp;
            }

            if (element.hasOwnProperty(global_problem_languages_string) && element[global_problem_languages_string] !== "") {
                temp = element.Languages.join(", ");
                element.Languages = temp;
            }
        });
        resolve(temp_json_data);
    });
}

//https://stackoverflow.com/a/35318609/420827
function createTable(json_data) {
    "use strict";
    return new Promise(function (resolve, reject) {
        var columnJson = $.map(Object.getOwnPropertyNames(json_data[0]), function (column) {
            if (column === global_problem_id_string) {
                return {"name": column, "title": column, "breakpoints": "xs", "type": "number", "style": {"width": 80, "maxWidth": 80}};
            } else if (column === global_problem_name_string || column === global_problem_companies_string || column === global_problem_tags_string) {
                return {"name": column, "title": column};
            } else {
                return {"name": column, "title": column, "breakpoints": "xs"};
            }
        });

        var count;
        if (json_data.length === 1 && json_data[0].Name === "") {
            count = 0;
        } else {
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


function adaptJsonData(json_data) {
    "use strict";
    return new Promise(function (resolve, reject) {
        json_data.forEach(function (element) {
            if (element.hasOwnProperty(global_problem_name_string) && element.hasOwnProperty(global_problem_link_string)) {
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

function populateFiltersDropdown() {
    "use strict";
    return new Promise(function (resolve, reject) {
        var items = global_origin.map(function (x) {
            return {label: x, title: x, value: x};
        });
        $('#input-origin').multiselect({
            includeSelectAllOption: true,
            enableFiltering: true,
            enableCaseInsensitiveFiltering: true,
            numberDisplayed: 0,
            nonSelectedText: 'Origin',
            maxHeight: 300,
            templates: {
                li: '<li><a class="dropdown-item"><label class="m-0 pl-2 pr-0"></label></a></li>',
                ul: ' <ul class="multiselect-container dropdown-menu p-1 m-0"></ul>',
                button: '<button type="button" class="multiselect dropdown-toggle" data-toggle="dropdown" data-flip="false"><span class="multiselect-selected-text"></span> <b class="caret"></b></button>',
                filter: '<li class="multiselect-item filter"><div class="input-group m-0"><input class="form-control multiselect-search" type="text"></div></li>',
                filterClearBtn: '<span class="input-group-btn"><button type="button" class="btn btn-secondary multiselect-clear-filter">&times;</button></span>'
            },
            onChange: function () {
                var brands = $('#input-origin option:selected');
                var selected = [];
                $(brands).each(function () {
                    selected.push($(this).val());
                });
                if (selected.length === 0) {
                    $('#filter-query-origin').html(global_filter_query_origin_default);
                } else {
                    var arrayAsString = selected.join(" OR ");
                    var text = "(" + arrayAsString + ")";
                    $('#filter-query-origin').html(text);
                }
            }
        });
        $('#input-origin').multiselect('dataprovider', items);

        items = global_companies.map(function (x) {
            return {label: x, title: x, value: x};
        });
        $('#input-companies').multiselect({
            includeSelectAllOption: true,
            enableFiltering: true,
            enableCaseInsensitiveFiltering: true,
            numberDisplayed: 0,
            nonSelectedText: 'Companies',
            maxHeight: 300,
            templates: {
                li: '<li><a class="dropdown-item"><label class="m-0 pl-2 pr-0"></label></a></li>',
                ul: ' <ul class="multiselect-container dropdown-menu p-1 m-0"></ul>',
                button: '<button type="button" class="multiselect dropdown-toggle" data-toggle="dropdown" data-flip="false"><span class="multiselect-selected-text"></span> <b class="caret"></b></button>',
                filter: '<li class="multiselect-item filter"><div class="input-group m-0"><input class="form-control multiselect-search" type="text"></div></li>',
                filterClearBtn: '<span class="input-group-btn"><button type="button" class="btn btn-secondary multiselect-clear-filter">&times;</button></span>'
            },
            onChange: function () {
                var brands = $('#input-companies option:selected');
                var selected = [];
                $(brands).each(function () {
                    selected.push($(this).val());
                });
                if (selected.length === 0) {
                    $('#filter-query-companies').html(global_filter_query_companies_default);
                } else {
                    var arrayAsString = selected.join(" OR ");
                    var text = "(" + arrayAsString + ")";
                    $('#filter-query-companies').html(text);
                }
            }
        });
        $('#input-companies').multiselect('dataprovider', items);

        items = global_categories.map(function (x) {
            return {label: x, title: x, value: x};
        });
        $('#input-categories').multiselect({
            includeSelectAllOption: true,
            enableFiltering: true,
            enableCaseInsensitiveFiltering: true,
            numberDisplayed: 0,
            nonSelectedText: 'Categories',
            maxHeight: 300,
            templates: {
                li: '<li><a class="dropdown-item"><label class="m-0 pl-2 pr-0"></label></a></li>',
                ul: ' <ul class="multiselect-container dropdown-menu p-1 m-0"></ul>',
                button: '<button type="button" class="multiselect dropdown-toggle" data-toggle="dropdown" data-flip="false"><span class="multiselect-selected-text"></span> <b class="caret"></b></button>',
                filter: '<li class="multiselect-item filter"><div class="input-group m-0"><input class="form-control multiselect-search" type="text"></div></li>',
                filterClearBtn: '<span class="input-group-btn"><button type="button" class="btn btn-secondary multiselect-clear-filter">&times;</button></span>'
            },
            onChange: function () {
                var brands = $('#input-categories option:selected');
                var selected = [];
                $(brands).each(function () {
                    selected.push($(this).val());
                });
                if (selected.length === 0) {
                    $('#filter-query-categories').html(global_filter_query_categories_default);
                } else {
                    var arrayAsString = selected.join(" OR ");
                    var text = "(" + arrayAsString + ")";
                    $('#filter-query-categories').html(text);
                }
            }
        });
        $('#input-categories').multiselect('dataprovider', items);

        items = global_tags.map(function (x) {
            return {label: x, title: x, value: x};
        });
        $('#input-tags').multiselect({
            includeSelectAllOption: true,
            enableFiltering: true,
            enableCaseInsensitiveFiltering: true,
            numberDisplayed: 0,
            nonSelectedText: 'Tags',
            maxHeight: 300,
            templates: {
                li: '<li><a class="dropdown-item"><label class="m-0 pl-2 pr-0"></label></a></li>',
                ul: ' <ul class="multiselect-container dropdown-menu p-1 m-0"></ul>',
                button: '<button type="button" class="multiselect dropdown-toggle" data-toggle="dropdown" data-flip="false"><span class="multiselect-selected-text"></span> <b class="caret"></b></button>',
                filter: '<li class="multiselect-item filter"><div class="input-group m-0"><input class="form-control multiselect-search" type="text"></div></li>',
                filterClearBtn: '<span class="input-group-btn"><button type="button" class="btn btn-secondary multiselect-clear-filter">&times;</button></span>'
            },
            onChange: function () {
                var brands = $('#input-tags option:selected');
                var selected = [];
                $(brands).each(function () {
                    selected.push($(this).val());
                });
                if (selected.length === 0) {
                    $('#filter-query-tags').html(global_filter_query_tags_default);
                } else {
                    var arrayAsString = selected.join(" OR ");
                    var text = "(" + arrayAsString + ")";
                    $('#filter-query-tags').html(text);
                }
            }
        });
        $('#input-tags').multiselect('dataprovider', items);

        items = global_languages.map(function (x) {
            return {label: x, title: x, value: x};
        });
        $('#input-languages').multiselect({
            includeSelectAllOption: true,
            enableFiltering: true,
            enableCaseInsensitiveFiltering: true,
            numberDisplayed: 0,
            nonSelectedText: 'Languages',
            maxHeight: 300,
            templates: {
                li: '<li><a class="dropdown-item"><label class="m-0 pl-2 pr-0"></label></a></li>',
                ul: ' <ul class="multiselect-container dropdown-menu p-1 m-0"></ul>',
                button: '<button type="button" class="multiselect dropdown-toggle" data-toggle="dropdown" data-flip="false"><span class="multiselect-selected-text"></span> <b class="caret"></b></button>',
                filter: '<li class="multiselect-item filter"><div class="input-group m-0"><input class="form-control multiselect-search" type="text"></div></li>',
                filterClearBtn: '<span class="input-group-btn"><button type="button" class="btn btn-secondary multiselect-clear-filter">&times;</button></span>'
            },
            onChange: function () {
                var brands = $('#input-languages option:selected');
                var selected = [];
                $(brands).each(function () {
                    selected.push($(this).val());
                });
                if (selected.length === 0) {
                    $('#filter-query-languages').html(global_filter_query_languages_default);
                } else {
                    var arrayAsString = selected.join(" OR ");
                    var text = "(" + arrayAsString + ")";
                    $('#filter-query-languages').html(text);
                }
            }
        });
        $('#input-languages').multiselect('dataprovider', items);

        var items_temp = ["and", "or"];
        items = items_temp.map(function (x) {
            return {label: x, title: x, value: x};
        });
        $('#input-and-or-origin-companies').multiselect({
            nonSelectedText: 'and/or',
            templates: {
                li: '<li><a class="dropdown-item"><label class="m-0 pl-2 pr-0"></label></a></li>',
                ul: ' <ul class="multiselect-container dropdown-menu p-1 m-0"></ul>',
                button: '<button type="button" class="multiselect dropdown-toggle" data-toggle="dropdown" data-flip="false"><span class="multiselect-selected-text"></span> <b class="caret"></b></button>',
                filter: '<li class="multiselect-item filter"><div class="input-group m-0"><input class="form-control multiselect-search" type="text"></div></li>',
                filterClearBtn: '<span class="input-group-btn"><button type="button" class="btn btn-secondary multiselect-clear-filter">&times;</button></span>'
            },
            onChange: function () {
                var brands = $('#input-and-or-origin-companies option:selected');
                var selected = [];
                $(brands).each(function () {
                    selected.push($(this).val());
                });
                if (selected.length === 0) {
                    $('#filter-query-and-or-origin-companies').html(global_filter_query_and_or_default);
                } else {
                    var arrayAsString = selected.join("");
                    $('#filter-query-and-or-origin-companies').html(arrayAsString);
                }
            }
        });
        $('#input-and-or-origin-companies').multiselect('dataprovider', items);
        $('#input-and-or-origin-companies').multiselect('select', ['and']);

        $('#input-and-or-companies-categories').multiselect({
            nonSelectedText: 'and/or',
            templates: {
                li: '<li><a class="dropdown-item"><label class="m-0 pl-2 pr-0"></label></a></li>',
                ul: ' <ul class="multiselect-container dropdown-menu p-1 m-0"></ul>',
                button: '<button type="button" class="multiselect dropdown-toggle" data-toggle="dropdown" data-flip="false"><span class="multiselect-selected-text"></span> <b class="caret"></b></button>',
                filter: '<li class="multiselect-item filter"><div class="input-group m-0"><input class="form-control multiselect-search" type="text"></div></li>',
                filterClearBtn: '<span class="input-group-btn"><button type="button" class="btn btn-secondary multiselect-clear-filter">&times;</button></span>'
            },
            onChange: function () {
                var brands = $('#input-and-or-companies-categories option:selected');
                var selected = [];
                $(brands).each(function () {
                    selected.push($(this).val());
                });
                if (selected.length === 0) {
                    $('#filter-query-and-or-companies-categories').html(global_filter_query_and_or_default);
                } else {
                    var arrayAsString = selected.join("");
                    $('#filter-query-and-or-companies-categories').html(arrayAsString);
                }
            }
        });
        $('#input-and-or-companies-categories').multiselect('dataprovider', items);
        $('#input-and-or-companies-categories').multiselect('select', ['and']);

        $('#input-and-or-categories-tags').multiselect({
            nonSelectedText: 'and/or',
            templates: {
                li: '<li><a class="dropdown-item"><label class="m-0 pl-2 pr-0"></label></a></li>',
                ul: ' <ul class="multiselect-container dropdown-menu p-1 m-0"></ul>',
                button: '<button type="button" class="multiselect dropdown-toggle" data-toggle="dropdown" data-flip="false"><span class="multiselect-selected-text"></span> <b class="caret"></b></button>',
                filter: '<li class="multiselect-item filter"><div class="input-group m-0"><input class="form-control multiselect-search" type="text"></div></li>',
                filterClearBtn: '<span class="input-group-btn"><button type="button" class="btn btn-secondary multiselect-clear-filter">&times;</button></span>'
            },
            onChange: function () {
                var brands = $('#input-and-or-categories-tags option:selected');
                var selected = [];
                $(brands).each(function () {
                    selected.push($(this).val());
                });
                if (selected.length === 0) {
                    $('#filter-query-and-or-categories-tags').html(global_filter_query_and_or_default);
                } else {
                    var arrayAsString = selected.join("");
                    $('#filter-query-and-or-companies-categories').html(arrayAsString);
                }
            }
        });
        $('#input-and-or-categories-tags').multiselect('dataprovider', items);
        $('#input-and-or-categories-tags').multiselect('select', ['and']);

        $('#input-and-or-tags-languages').multiselect({
            nonSelectedText: 'and/or',
            templates: {
                li: '<li><a class="dropdown-item"><label class="m-0 pl-2 pr-0"></label></a></li>',
                ul: ' <ul class="multiselect-container dropdown-menu p-1 m-0"></ul>',
                button: '<button type="button" class="multiselect dropdown-toggle" data-toggle="dropdown" data-flip="false"><span class="multiselect-selected-text"></span> <b class="caret"></b></button>',
                filter: '<li class="multiselect-item filter"><div class="input-group m-0"><input class="form-control multiselect-search" type="text"></div></li>',
                filterClearBtn: '<span class="input-group-btn"><button type="button" class="btn btn-secondary multiselect-clear-filter">&times;</button></span>'
            },
            onChange: function () {
                var brands = $('#input-and-or-tags-languages option:selected');
                var selected = [];
                $(brands).each(function () {
                    selected.push($(this).val());
                });
                if (selected.length === 0) {
                    $('#filter-query-and-or-tags-languages').html(global_filter_query_and_or_default);
                } else {
                    var arrayAsString = selected.join("");
                    $('#filter-query-and-or-tags-languages').html(arrayAsString);
                }
            }
        });
        $('#input-and-or-tags-languages').multiselect('dataprovider', items);
        $('#input-and-or-tags-languages').multiselect('select', ['and']);

        resolve("Success!");
    });
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

function getFilteredJson() {
    "use strict";
    return new Promise(function (resolve, reject) {
        global_filtered_json_data = [];
        var filter_origins = [];
        var temp = $('#input-origin option:selected').map(function (a, item) {
            return item.value;
        });
        _.forEach(temp, function (item) {
            filter_origins.push(item);
        });
        var filter_companies = [];
        temp = $('#input-companies option:selected').map(function (a, item) {
            return item.value;
        });
        _.forEach(temp, function (item) {
            filter_companies.push(item);
        });
        var filter_categories = [];
        temp = $('#input-categories option:selected').map(function (a, item) {
            return item.value;
        });
        _.forEach(temp, function (item) {
            filter_categories.push(item);
        });
        var filter_tags = [];
        temp = $('#input-tags option:selected').map(function (a, item) {
            return item.value;
        });
        _.forEach(temp, function (item) {
            filter_tags.push(item);
        });
        var filter_languages = [];
        temp = $('#input-languages option:selected').map(function (a, item) {
            return item.value;
        });
        _.forEach(temp, function (item) {
            filter_languages.push(item);
        });

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

        temp = $('#input-and-or-origin-companies option:selected').map(function (a, item) {
            return item.value;
        });
        var and_or_origin_companies = _.join(temp, "");
        temp = $('#input-and-or-companies-categories option:selected').map(function (a, item) {
            return item.value;
        });
        var and_or_companies_categories = _.join(temp, "");
        temp = $('#input-and-or-categories-tags option:selected').map(function (a, item) {
            return item.value;
        });
        var and_or_categories_tags = _.join(temp, "");
        temp = $('#input-and-or-tags-languages option:selected').map(function (a, item) {
            return item.value;
        });
        var and_or_tags_languages = _.join(temp, "");

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
            var filtered_data_object = {};
            filtered_data_object[global_problem_id_string] = "";
            filtered_data_object[global_problem_name_string] = "";
            filtered_data_object[global_problem_origin_string] = "";
            filtered_data_object[global_problem_link_string] = "";
            filtered_data_object[global_problem_companies_string] = "";
            filtered_data_object[global_problem_categories_string] = "";
            filtered_data_object[global_problem_tags_string] = "";
            filtered_data_object[global_problem_languages_string] = "";
            filtered_data.push(filtered_data_object);
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
                $('#input-origin').multiselect('deselectAll', false);
                $('#input-origin').multiselect('updateButtonText');
                $('#input-companies').multiselect('deselectAll', false);
                $('#input-companies').multiselect('updateButtonText');
                $('#input-categories').multiselect('deselectAll', false);
                $('#input-categories').multiselect('updateButtonText');
                $('#input-tags').multiselect('deselectAll', false);
                $('#input-tags').multiselect('updateButtonText');
                $('#input-languages').multiselect('deselectAll', false);
                $('#input-languages').multiselect('updateButtonText');
                $('#input-and-or-origin-companies').multiselect('deselectAll', false);
                $('#input-and-or-origin-companies').multiselect('updateButtonText');
                $('#input-and-or-companies-categories').multiselect('deselectAll', false);
                $('#input-and-or-companies-categories').multiselect('updateButtonText');
                $('#input-and-or-categories-tags').multiselect('deselectAll', false);
                $('#input-and-or-categories-tags').multiselect('updateButtonText');
                $('#input-and-or-tags-languages').multiselect('deselectAll', false);
                $('#input-and-or-tags-languages').multiselect('updateButtonText');
            })
            .then(function () {
                global_filtered_json_data = [];
                global_filters_applied = false;
                $('#filter-query-origin').html(global_filter_query_origin_default);
            });
    }
}
//https://github.com/lodash/lodash/issues/1743#issuecomment-298957228
function arrayContainsArray(superset, subset) {
    "use strict";
    return subset.every(function (value) {
        return (superset.indexOf(value) >= 0);
    });
}

jQuery(function () {
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