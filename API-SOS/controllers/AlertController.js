'use strict';

let model = require('../models/AlertModel');

exports.addA = function(req, res){
    res.json(model.add(req.body));
};

exports.getAlertByU = function(req, res){
    res.json(model.getByUser(req.params.userId));
};
