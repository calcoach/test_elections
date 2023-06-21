const express = require('express')
const mysql = require('mysql')
const cors = require('cors')
const { json } = require('express')
const app = express()

app.use(express.json())
app.use(cors())
//Establecemos los prámetros de conexión
const conexion = mysql.createConnection({
    host:'localhost',
    port:'3306',
    user:'root',
    password:'12345',
    database:'db_elections'
})
//Conexión a la database
conexion.connect(function(error){
    if(error){
        throw error
    }else{
        console.log("¡Conexión exitosa a la base de datos!")
    }
})
app.get('/', function(req,res){
    res.send('Ruta INICIO')
})
//Consultar el año con mas votos los platillos
app.get('/api/morevotes', (req,res)=>{
    conexion.query('SELECT  e.year FROM election e group by e.year order by sum(e.vote_count) desc limit 1', (error,fila)=>{
        if(error){
            throw error
        }else{
            console.log(fila);
            res.send(fila)
        }
    })
})

app.get('/api/minusvotesyear', (req,res)=>{
    conexion.query('SELECT  e.year FROM election e where e.year between 2012 AND 2016 group by e.year order by sum(e.vote_count) asc limit 1;', 
    (error,fila)=>{
        if(error){
            throw error
        }else{
            console.log(fila);
            res.send(fila)
        }
    })
})
//Buscar platillo por id
app.get('/api/minusvotes', (req,res)=>{
    conexion.query("select county from county c join (SELECT sum(e.vote_count) votos, e.code_county FROM election e group by e.code_county order by votos desc limit 1) county_more_votes on c.code_county =  county_more_votes.code_county", 
    (error, fila)=>{
        if(error){
            throw error
        }else{
            res.send(fila)
        }
    })
})


app.get('/api/democractmorevotes', (req,res)=>{
    conexion.query("select county from county c join (SELECT sum(e.vote_count) votos, e.code_county FROM election e where e.political_party = 'Democract' AND e.year between 2000 AND 2016 group by e.code_county order by votos desc limit 3) county_more_votes on c.code_county =  county_more_votes.code_county", 
    (error, fila)=>{
        if(error){
            throw error
        }else{
            res.send(fila)
        }
    })
})

app.get('/api/partymorevotes', (req,res)=>{
    conexion.query("SELECT sum(e.vote_count) votos, e.political_party FROM election e where e.year between 2000 AND 2016 group by e.political_party order by votos desc limit 1", 
    (error, fila)=>{
        if(error){
            throw error
        }else{
            res.send(fila)
        }
    })
})

app.get('/api/votesbyyearandpoliticalparty', (req,res)=>{
    conexion.query("SELECT e.year, e.political_party, sum(e.vote_count) votos FROM election e group by e.year, e.political_party", 
    (error, fila)=>{
        if(error){
            throw error
        }else{
            res.send(fila)
        }
    })
})


const puerto = process.env.PUERTO || 5000
app.listen(puerto, function(){
    console.log("Servidor Ok en puerto:"+puerto)
})
