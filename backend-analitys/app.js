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
//Consultar todos los platillos
app.get('/api/platillos', (req,res)=>{
    conexion.query('SELECT * FROM platillos', (error,filas)=>{
        if(error){
            throw error
        }else{
            res.send(filas)
        }
    })
})
//Buscar platillo por id
app.get('/api/platillos/:id', (req,res)=>{
    conexion.query('SELECT * FROM platillos WHERE idplatillo = ?', [req.params.id], (error, fila)=>{
        if(error){
            throw error
        }else{
            res.send(fila)
        }
    })
})
//Crear un platillo
app.post('/api/platillos', (req,res)=>{
    let data = {descripcion:req.body.descripcion, precio:req.body.precio, stock:req.body.stock}
    let sql = "INSERT INTO platillos SET ?"
    conexion.query(sql, data, function(err, result){
            if(err){
               throw err
            }else{
             /*Esto es lo nuevo que agregamos para el CRUD con Javascript*/
             Object.assign(data, {id: result.insertId }) //agregamos el ID al objeto data
             res.send(data) //enviamos los valores
        }
    })
})
//Editar un platillo
app.put('/api/platillos/:id', (req, res)=>{
    let id = req.params.id
    let descripcion = req.body.descripcion
    let precio = req.body.precio
    let stock = req.body.stock
    let sql = "UPDATE platillos SET nameplatillo = ?, precio = ?, ingredientes = ?, tiempopreparacion WHERE id = ?"
    conexion.query(sql, [descripcion, precio, stock, id], function(error, results){
        if(error){
            throw error
        }else{
            res.send(results)
        }
    })
})
//Eliminar un platillo
app.delete('/api/platillos/:id', (req,res)=>{
    conexion.query('DELETE FROM platillos WHERE id = ?', [req.params.id], function(error, filas){
        if(error){
            throw error
        }else{
            res.send(filas)
        }
    })
})
const puerto = process.env.PUERTO || 5000
app.listen(puerto, function(){
    console.log("Servidor Ok en puerto:"+puerto)
})
