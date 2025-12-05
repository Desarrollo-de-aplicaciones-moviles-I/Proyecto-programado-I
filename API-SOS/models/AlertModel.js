'use strict';

var _ = require('underscore');
var util = require('../util/util');
var httpresponse = require('../util/httpResponse');
var jsonFile = './data/alert.json';

let dataSource = JSON.parse(util.readFile(jsonFile));

exports.get_all = function(){
    return {data: dataSource, responseCode: httpresponse.OK, message: 'Action executed successfully.'};
};

exports.getByUser = function(userId){
    var filtered = dataSource.filter(a => a.IdUser === userId);
    return {data: filtered, responseCode: httpresponse.OK, message: 'Action executed successfully.'};
};

exports.add = function(alert){
    if(!alert || JSON.stringify(alert) === '{}'){
        return {data: null, responseCode: httpresponse.BAD_REQUEST, message: 'Body is required.'};
    }

    // Generar ID único
    let newId;
    do {
        newId = Math.floor(Math.random()*999999)+1;
    } while(dataSource.some(a => a.IdAlert === newId));
    alert.IdAlert = newId;

    dataSource.push(alert);
    util.writeFile(JSON.stringify(dataSource), jsonFile);
    return {data: alert, responseCode: httpresponse.OK, message: 'Alert added successfully.'};
};
