'use strict';
module.exports = function (app){
    var user = require('../controllers/UserController');
    var contact = require('../controllers/ContactController');
    var alert = require('../controllers/AlertController');

// -------------------- USER --------------------
    app.route('/user')
        .post(user.create);

    app.route('/user/username/:username')
        .get(user.get_by_username);

    app.route('/user/email/:email')
        .get(user.get_by_email);

    app.route('/user/:username/password')
        .put(user.update_password);

    app.route('/user/:username/phone')
        .put(user.update_phone);

    app.route('/user/login')
        .post(user.login);

    app.route('/user/logout')
        .post(user.logout);

// -------------------- CONTACTS --------------------
    app.route('/contact')
        .post(contact.create);

    app.route('/contact/:name')
        .put(contact.update)

    app.route('/contact/:name')
        .delete(contact.remove);

    app.route('/contact/user/:username')
        .get(contact.get_contact_by_user);

    app.route('/contact/name/:contactName')
        .get(contact.get_contact_by_name);

    app.route('/contact/phone/:phoneNumber')
        .get(contact.get_contact_by_phone);

// -------------------- ALERTS --------------------
    app.route('/alerts')
        .post(alert.addA);

    app.route('/alerts/user/:userId')
        .get(alert.getAlertByU);

};