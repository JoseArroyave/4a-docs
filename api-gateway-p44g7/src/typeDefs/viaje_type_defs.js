const { gql } = require('apollo-server');

const viajeTypeDefs = gql`

    type Viaje {
        conductor: String!
        cliente: Boolean!
        direccionOrigen: String!
        direccionDestino: String!
        precio: Float!
    }
    input ViajeInput{
        conductor: String!
        cliente: Boolean!
        direccionOrigen: String!
        direccionDestino: String!
        precio: Float!
    }
    extend type Query {
        findByConductor(conductor: String!): [Viaje]
    }
    extend type Mutation {
        nuevoViaje(viaje: ViajeInput!): Viaje
        viajeTerminado(id: String!): Viaje
    }
`;
module.exports = viajeTypeDefs;