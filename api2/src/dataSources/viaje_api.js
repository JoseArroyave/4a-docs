const { RESTDataSource } = require('apollo-datasource-rest');
const serverConfig = require('../server');
class ViajeAPI extends RESTDataSource {
    constructor() {
        super();
        this.baseURL = serverConfig.viajes_api_url;
    }
    async createViaje(viaje) {
        viaje = new Object(JSON.parse(JSON.stringify(viaje)));
        return await this.post(`/viaje/`, viaje);
    }
    async getByConductor(conductor) {
        return await this.get(`/viajes/${conductor}`);
    }
    async getByCliente() {
        return await this.get('/viajeslist');
    }
    async terminarViaje(id) {
        return await this.put(`/viaje/terminado/${id}`);
    }
    async createConductor(conductor) {
        conductor = new Object(JSON.parse(JSON.stringify(conductor)));
        return await this.post(`/conductor/`, conductor);
    }
    async getConductor(cedula) {
        return await this.get(`/conductor/${cedula}`);
    }
    async getDisponibles() {
        return await this.get('/conductor/disponibles');
    }
    async getElegido() {
        return await this.get('/conductor/elegido');
    }
}
module.exports = ViajeAPI;