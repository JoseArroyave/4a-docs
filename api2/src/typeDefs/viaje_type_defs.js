const { gql } = require('apollo-server');

const viajeTypeDefs = gql`

    type Viaje {
        id: String
        conductor: String
        cliente: String
        esAmigo: Boolean
        direccionOrigen: String
        direccionDestino: String
        precio: Float
        fechaViaje: String
        activo: Boolean
    }
    input ViajeInput{
        conductor: String!
        cliente: String!
        esAmigo: Boolean!
        direccionOrigen: String!
        direccionDestino: String!
        precio: Float!
        activo: Boolean!
    }
    
   type Query {
        getByConductor(conductor: String!): [Viaje]
    }
   extend type Mutation {
        createViaje(viaje: ViajeInput!): Viaje
        terminarViaje(id: String!): Viaje
    }
`;
module.exports = viajeTypeDefs;