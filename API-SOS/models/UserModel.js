'use strict';

var _ = require('underscore');
var util = require('../util/util');
var httpresponse = require('../util/httpResponse');
var jsonFile = './data/user.json';

let dataSource = JSON.parse(util.readFile(jsonFile));

exports.get_all = function(){
    return {
        data: dataSource,
        responseCode: httpresponse.OK,
        message: 'Action executed successfully.'
    };
};

exports.getByUsername = function(username){
    var filtered = dataSource.filter(u => u.Username === username);
    return {
        data: filtered,
        responseCode: filtered.length > 0 ? httpresponse.OK : httpresponse.BAD_REQUEST,
        message: filtered.length > 0 ? 'Action executed successfully.' : 'User not found.'
    };
};

exports.getByEmail = function(email){
    var filtered = dataSource.filter(u => u.Email === email);
    return {
        data: filtered,
        responseCode: filtered.length > 0 ? httpresponse.OK : httpresponse.BAD_REQUEST,
        message: filtered.length > 0 ? 'Action executed successfully.' : 'User not found.'
    };
};

exports.create = function(user){
    if (!user || JSON.stringify(user) === '{}'){
        return {data: null, responseCode: httpresponse.BAD_REQUEST, message: 'Body is required.'};
    }

    var exists = this.getByUsername(user.Username);
    if (exists.data.length > 0){
        return {data: null, responseCode: httpresponse.BAD_REQUEST, message: 'User already exists.'};
    }

    dataSource.push(user);
    util.writeFile(JSON.stringify(dataSource), jsonFile);
    return {data: user, responseCode: httpresponse.OK, message: 'User created successfully.'};
};

exports.updatePassword = function(username, newPassword){
    var user = dataSource.find(u => u.Username === username);
    if(user){
        user.Password = newPassword;
        util.writeFile(JSON.stringify(dataSource), jsonFile);
        return {data: user, responseCode: httpresponse.OK, message: 'Password updated successfully.'};
    } else {
        return {data: null, responseCode: httpresponse.BAD_REQUEST, message: 'User not found.'};
    }
};

exports.updatePhone = function(username, newPhone){
    var user = dataSource.find(u => u.Username === username);
    if(user){
        user.PhoneNumber = newPhone;
        util.writeFile(JSON.stringify(dataSource), jsonFile);
        return {data: user, responseCode: httpresponse.OK, message: 'Phone updated successfully.'};
    } else {
        return {data: null, responseCode: httpresponse.BAD_REQUEST, message: 'User not found.'};
    }
};

exports.login = function(username, password){
    var user = dataSource.find(u => u.Username === username && u.Password === password);
    if(user){
        return {data: user, responseCode: httpresponse.OK, message: 'Login successful.'};
    } else {
        return {data: null, responseCode: httpresponse.BAD_REQUEST, message: 'Invalid credentials.'};
    }
};

exports.logout = function(username){
    //La respuesta es simulada
    return {data: username, responseCode: httpresponse.OK, message: 'Logout successful.'};
};
