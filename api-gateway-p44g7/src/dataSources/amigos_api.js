const { RESTDataSource } = require('apollo-datasource-rest');

const serverConfig = require('../server');

class AmigoAPI extends RESTDataSource {
    constructor() {
        super();
        this.baseURL = serverConfig.auth_api_url;
    }
    async createAmigo(amigos) {
        amigos = new Object(JSON.parse(JSON.stringify(amigos)));
        return await this.post('/amigos/', amigos);
    }
    async getbyCliente() {
        return await this.get(`/amigos/lista/${cliente}`);
    }
}
module.exports = AmigoAPI;