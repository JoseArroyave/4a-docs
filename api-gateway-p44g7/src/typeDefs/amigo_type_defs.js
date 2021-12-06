const { gql } = require('apollo-server');

const amigoTypeDefs = gql `

    type Amigos {
        id_amigo: String!
        nombre: String!
        apellidos: String!
        email: String!
        telefono: Float!
        cliente: Float!
    }
    input AmigosInput{
        id_amigo: String!
        nombre: String!
        apellidos: String!
        email: String!
        telefono: Float!
        cliente: Float!
    }
    extend type Query {
        findByCliente(cliente: String!): [Amigos]
    }
    extend type Mutation {
        nuevoAmigo(amigos: AmigosInput!): Amigos
    }
`;
module.exports = amigoTypeDefs;