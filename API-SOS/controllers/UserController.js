'use strict';

let model = require('../models/UserModel');

exports.create = function(req, res){
    res.json(model.create(req.body));
};

exports.get_by_username = function(req, res){
    res.json(model.getByUsername(req.params.username));
};

exports.get_by_email = function(req, res){
    res.json(model.getByEmail(req.params.email));
};

exports.update_password = function(req, res){
    res.json(model.updatePassword(req.params.username, req.body.newPassword));
};

exports.update_phone = function(req, res){
    res.json(model.updatePhone(req.params.username, req.body.newPhone));
};

exports.login = function(req, res){
    res.json(model.login(req.body.username, req.body.password));
};

exports.logout = function(req, res){
    res.json(model.logout(req.body.username));
};