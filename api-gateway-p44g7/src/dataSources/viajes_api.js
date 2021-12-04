const { RESTDataSource } = require('apollo-datasource-rest');

const serverConfig = require('../server');

class ViajeAPI extends RESTDataSource {
    constructor() {
        super();
        this.baseURL = serverConfig.viajes_api_url;
    }
    async createViaje(viaje) {
        viaje = new Object(JSON.parse(JSON.stringify(viaje)));
        return await this.post('/viaje', viaje);
    }
    async getbyConductor(conductor) {
        return await this.get(`/viajes/${conductor}`);
    }
    async terminarViaje(id) {
        return await this.put(`/viajes/${id}`);
    }
}
module.exports = ViajeAPI;