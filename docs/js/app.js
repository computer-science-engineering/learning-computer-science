var adapted_json_data = [];
var companies = [];
var categories = [];
var tags = [];
var languages = [];

var getJson = new Promise((resolve, reject) => {
    fetch('https://raw.githubusercontent.com/manastalukdar/learning_computer-science/master/docs/problems_list.json',
        {mode: 'cors'}) //'problems_list.json'
        .then(res => res.json())
        .then(json_data => resolve(json_data));
});

function createTable(adapted_json_data) {
    return new Promise((resolve, reject) => {
        var columnJson = $.map(Object.getOwnPropertyNames(adapted_json_data[0]), function (column) {
            return {"name": column,"title": column}
        });
        
        createFooTable(columnJson, adapted_json_data)
        .then(() => resolve("Success!"))        
    });
}

function adaptJsonData(json_data) {
    return new Promise((resolve, reject) => {
        json_data.forEach(element => {
            if ("Problem" in element && "Link" in element) {
                var problem_name = element["Problem"];
                var link = "https://github.com/manastalukdar/learning_computer-science/tree/master/" + element["Link"];
                element["Problem"] = "<a href=\"" + link + "\" target=\"_blank\">" + problem_name + "</a>"
                delete element.Link
            }

            if ("Companies" in element) {
                var values = element["Companies"];
                values.forEach(item => {
                    if (this.companies.indexOf(item) === -1) {
                        this.companies.push(item);
                    }
                })
            }

            if ("Categories" in element) {
                var values = element["Categories"];
                values.forEach(item => {
                    if (this.categories.indexOf(item) === -1) {
                        this.categories.push(item);
                    }
                })
            }

            if ("Tags" in element) {
                var values = element["Tags"];
                values.forEach(item => {
                    if (this.tags.indexOf(item) === -1) {
                        this.tags.push(item);
                    }
                })
            }

            if ("Languages" in element) {
                var values = element["Languages"];
                values.forEach(item => {
                    if (this.languages.indexOf(item) === -1) {
                        this.languages.push(item);
                    }
                })
            }
        });
        this.adapted_json_data = json_data;
        resolve(this.adapted_json_data);
    });
}

function createFooTable(columns, row_data) {
    return new Promise((resolve, reject) => {
        $('.table').footable({
            columns: columns,
            rows: row_data
        });
        resolve("Success!");
    });
}

jQuery(function($){
    // getJson
    // .then(json_data => adaptJsonData(json_data))
    // .then(adapted_json_data => createTable(adapted_json_data))
    // .then(() => {
    //     if (typeof this.companies === "undefined") {
    //         alert("this.companies is undefined");
    //     }
    //     $("#input-companies").val(this.companies.join(","));
    // })
    // .then(() => {
    //     $('#input-companies').selectize({
    //         delimiter: ',',
    //         persist: false,
    //         create: function(input) {
    //             return {
    //                 //value: this.companies,
    //                 //text: this.companies
    //             }
    //         }
    //     });
    // })
});

async function dumb() {
    console.log('Taking a break...');
    await sleep(5000);
    console.log('Two second later');
  }

function sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}

function createHtmlTable(json_data) {
    //http://www.encodedna.com/javascript/populate-json-data-to-html-table-using-javascript.htm

    var col = [];

    // EXTRACT VALUE FOR HTML HEADER.
    for (var i = 0; i < json_data.length; i++) {
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


