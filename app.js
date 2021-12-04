const socketio = require("socket.io");
const express = require('express')
const http = require("http");

//express 서버 생성
const app = new express();
const server = http.createServer(app);


const io = socketio(server);
io.on("connection",(socket)=> {
    console.log(`[connect client]  : ${socket.id}`)

    socket.on("disconnect",()=>{
        console.log(`[disconnect client]  : ${socket.id}`)
        
    });

    socket.on("location",function(data){
        console.log("user location connect");
        console.log("location : " + data);
    })
})


// 5000 포트로 서버 오픈
server.listen(5000, function() {
    console.log("start! express server on port 5000")
})


app.get('/', function(req,res) {
    res.send("<h1>road eye!</h1>")
})