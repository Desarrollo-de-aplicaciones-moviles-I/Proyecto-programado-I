'use strict';

var _ = require('underscore');
var util = require('../util/util');
var httpresponse = require('../util/httpResponse');
var jsonFile = './data/contact.json';

let dataSource = JSON.parse(util.readFile(jsonFile));

exports.get_all = function(){
    return {data: dataSource, responseCode: httpresponse.OK, message: 'Action executed successfully.'};
};

exports.getByUser = function(username){
    var filtered = dataSource.filter(c => c.NameUser === username);
    return {data: filtered, responseCode: httpresponse.OK, message: 'Action executed successfully.'};
};

exports.getByName = function(name){
    var filtered = dataSource.filter(c => c.Name === name);
    return {data: filtered, responseCode: filtered.length > 0 ? httpresponse.OK : httpresponse.BAD_REQUEST, message: filtered.length > 0 ? 'Action executed successfully.' : 'Contact not found.'};
};

exports.getByPhone = function(phone){
    var filtered = dataSource.filter(c => c.PhoneNumber === phone);
    return {data: filtered, responseCode: filtered.length > 0 ? httpresponse.OK : httpresponse.BAD_REQUEST, message: filtered.length > 0 ? 'Action executed successfully.' : 'Contact not found.'};
};

exports.create = function(contact){
    if(!contact || JSON.stringify(contact) === '{}'){
        return {data: null, responseCode: httpresponse.BAD_REQUEST, message: 'Body is required.'};
    }

    var exists = this.getByName(contact.Name);
    if(exists.data.length > 0){
        return {data: null, responseCode: httpresponse.BAD_REQUEST, message: 'Contact already exists.'};
    }

    dataSource.push(contact);
    util.writeFile(JSON.stringify(dataSource), jsonFile);
    return {data: contact, responseCode: httpresponse.OK, message: 'Contact created successfully.'};
};

exports.update = function(contact){
    var index = dataSource.findIndex(c => c.Name === contact.Name);
    if(index >= 0){
        dataSource[index] = contact;
        util.writeFile(JSON.stringify(dataSource), jsonFile);
        return {data: contact, responseCode: httpresponse.OK, message: 'Contact updated successfully.'};
    } else {
        return {data: null, responseCode: httpresponse.BAD_REQUEST, message: 'Contact not found.'};
    }
};

exports.remove = function(name){
    var index = dataSource.findIndex(c => c.Name === name);
    if(index >= 0){
        var removed = dataSource.splice(index,1)[0];
        util.writeFile(JSON.stringify(dataSource), jsonFile);
        return {data: removed, responseCode: httpresponse.OK, message: 'Contact removed successfully.'};
    } else {
        return {data: null, responseCode: httpresponse.BAD_REQUEST, message: 'Contact not found.'};
    }
};
