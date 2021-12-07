const { gql } = require('apollo-server');

const conductorTypeDefs = gql`

    type Conductor {
        cedula: String
        nombres: String
        apellidos: String
        telefono: String
        tipoCarro: String
        disponible: Boolean
        balance: Float
    }
    input ConductorInput{
        cedula: String!
        nombres: String!
        apellidos: String!
        telefono: String!
        tipoCarro: String!
        disponible: Boolean!
        balance: Float!
    }
    
   extend type Query {
        getConductor(cedula: String!): Conductor
        getDisponibles: [Conductor]
        getElegido: Conductor
    }
   extend type Mutation {
        createConductor(conductor: ConductorInput!): Conductor
    }
`;
module.exports = conductorTypeDefs;