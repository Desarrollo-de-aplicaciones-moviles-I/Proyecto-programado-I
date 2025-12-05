'use strict';

let model = require('../models/ContactModel');

exports.create = function(req, res){
    res.json(model.create(req.body));
};

exports.update = function(req, res){
    res.json(model.update(req.body));
};

exports.remove = function(req, res){
    res.json(model.remove(req.params.name));
};

exports.get_contact_by_user = function(req, res){
    res.json(model.getByUser(req.params.username));
};

exports.get_contact_by_name = function(req, res){
    res.json(model.getByName(req.params.contactName));
};

exports.get_contact_by_phone = function(req, res){
    res.json(model.getByPhone(req.params.phoneNumber));
};
