/*jslint es6 */

var adapted_json_data = [];
var origin = [];
var companies = [];
var categories = [];
var tags = [];
var languages = [];

var getJson = new Promise(function(resolve, reject) {
    "use strict";
    fetch('https://raw.githubusercontent.com/manastalukdar/learning_computer-science/master/docs/problems_list.json',
        {mode: 'cors'}) //'problems_list.json'
        .then((res) => res.json())
        .then((json_data) => resolve(json_data));
});

//https://stackoverflow.com/a/35318609/420827

function createTable(adapted_json_data) {
    "use strict";
    return new Promise(function(resolve, reject) {
        var columnJson = $.map(Object.getOwnPropertyNames(adapted_json_data[0]), function (column) {
            return {"name": column,"title": column};
        });

        createFooTable(columnJson, adapted_json_data)
        .then(() => resolve("Success!"));
    });
}

function adaptJsonData(json_data) {
    "use strict";
    return new Promise(function(resolve, reject) {
        json_data.forEach(function(element) {
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
                values.forEach(function(item) {
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
    return new Promise(function(resolve, reject) {
        $('.table').footable({
            columns: columns,
            rows: row_data
        });
        resolve("Success!");
    });
}

function populateDropdownFilters() {
    "use strict";
    return new Promise(function(resolve, reject) {
        var items = origin.map(function(x) { return { item: x }; });
        $('#input-origin').selectize({
            delimiter: ',',
            persist: false,
            options: items,
            labelField: "item",
            valueField: "item",
            searchField: 'item'
        });

        items = companies.map(function(x) { return { item: x }; });
        $('#input-companies').selectize({
            delimiter: ',',
            persist: false,
            options: items,
            labelField: "item",
            valueField: "item",
            searchField: 'item'
        });

        items = categories.map(function(x) { return { item: x }; });
        $('#input-categories').selectize({
            delimiter: ',',
            persist: false,
            options: items,
            labelField: "item",
            valueField: "item",
            searchField: 'item'
        });

        items = tags.map(function(x) { return { item: x }; });
        $('#input-tags').selectize({
            delimiter: ',',
            persist: false,
            options: items,
            labelField: "item",
            valueField: "item",
            searchField: 'item'
        });

        items = languages.map(function(x) { return { item: x }; });
        $('#input-languages').selectize({
            delimiter: ',',
            persist: false,
            options: items,
            labelField: "item",
            valueField: "item",
            searchField: 'item'
        });
    });
}

jQuery(function($){
    "use strict";
    // getJson
    // .then((json_data) => adaptJsonData(json_data))
    // .then((adapted_json_data) => createTable(adapted_json_data)) //$("#input-companies").val(companies.join(","));    
    // .then(function() {
    //     populateDropdownFilters();
    // });
});

function sleep(ms) {
    "use strict";
    return new Promise((resolve) => setTimeout(resolve, ms));
}

function createHtmlTable(json_data) {
    "use strict";
    //http://www.encodedna.com/javascript/populate-json-data-to-html-table-using-javascript.htm

    var col = [];

    // EXTRACT VALUE FOR HTML HEADER.
    for(var i = 0; i < json_data.length; i++) {
        for (var key in json_data[i]) {
            if (col.indexOf(key) === -1) {
                col.push(key);
            }
        }
    }

    //createTable(col, json_data)

    // CREATE DYNAMIC TABLE.
    //var table = document.createElement("table");
    var table = document.getElementById("problems_list_table");

    // CREATE HTML TABLE HEADER ROW USING THE EXTRACTED HEADERS ABOVE.
    var tr = table.insertRow(-1); // TABLE ROW.

    for (var i = 0; i < col.length; i++) {
        var th = document.createElement("th"); // TABLE HEADER.
        th.innerHTML = col[i];
        tr.appendChild(th);
    }

    // ADD JSON DATA TO THE TABLE AS ROWS.
    for (var i = 0; i < json_data.length; i++) {
        tr = table.insertRow(-1);
        for (var j = 0; j < col.length; j++) {
            var tabCell = tr.insertCell(-1);
            tabCell.innerHTML = json_data[i][col[j]];
        }
    }

    // FINALLY ADD THE NEWLY CREATED TABLE WITH JSON DATA TO A CONTAINER.
    //var divContainer = document.getElementById("showData");
    //divContainer.innerHTML = "";
    //divContainer.appendChild(table);

    $('.table').footable();
}


