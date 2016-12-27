function serverStart(dbConn) {
	var http =  require('http');
	var cors =require('cors');
	http.createServer(function (req, res) {
    //Handle the first Option Request--CORS    
    var origin = (req.headers.origin || "*");

    if (req.method.toUpperCase() === "OPTIONS"){

    	res.writeHead(
    		"204",
    		"No Content",
    		{
    			"access-control-allow-origin": origin,
    			"access-control-allow-methods": "GET, POST, PUT, DELETE, OPTIONS",
    			"access-control-allow-headers": "content-type, accept",
                    "access-control-max-age": 10, // Seconds.
                    "content-length": 0
                }
                );

    	return( res.end() );


    }

    var usr_info={
    	uID:'',
    	pass:'',
    	email:'',
    	q0:'',
    	a0:'',
    	q1:'',
    	a1:'',
    	mnum:'',
    	add:'',
    	aoi:''
    };
	//Extract and Call DB
	if(req.url==='/register'&&req.method=='POST'){
		req.on('data',function (chunk) {
			
			var bodyParsed=JSON.parse(chunk);
			usr_info.uID=bodyParsed.uID;
			usr_info.pass=bodyParsed.pass;
			usr_info.email=bodyParsed.email;
			usr_info.q0=bodyParsed.q0;
			usr_info.a0=bodyParsed.a0;
			usr_info.q1=bodyParsed.q1;
			usr_info.a1=bodyParsed.a1;
			usr_info.mnum=bodyParsed.mnum;
			usr_info.add=bodyParsed.add;
			usr_info.aoi=bodyParsed.aoi;
			//Call the DB method
			dbConn(usr_info, function(err){
				if(err){
           //Error Handling
           console.log("Failure "+err.message);
           res.writeHead(400,"DB error: "+err.message,{'Content-Type': 'text/html',
           	'access-control-allow-origin':'*'});
           res.end();
       }
       else
       {
       	res.writeHead(200, "User Registered", {'Content-Type': 'text/html',
       		'access-control-allow-origin':'*'});
       	res.end(); 
       }
   });
		});

		


	}
	else {
            //Wrong Request
            console.log("[405] " + req.method + " to " + req.url);
            res.writeHead(405, "Method not supported", {'Content-Type': 'text/html'});
            res.end('<html><head><title>405 - Method not supported</title></head><body><h1>Method not supported.</h1></body></html>');
        }
    }).listen(8080);
}


serverStart(function dbConnection(usr_info, callback) {
	//Db conncection
	var mysql = require('mysql');
	var connection = mysql.createConnection({
		host     : 'localhost',
		user     : 'root',
  password : '123456',//Change the password and user as per DB
  database : 'UsrReg'
});

	connection.connect();

	connection.query('INSERT INTO usr_info SET ?',usr_info, function(err, result) {
		if (err) {
			callback(err);
			return connection.rollback(function() {
          // throw err;
      });
		}  
		connection.commit(function(err) {
			if (err) {
				callback(err);
				return connection.rollback(function() {
            // throw err;
        });
			}
			callback();
			console.log('success!');

		});

		connection.end();	
	});

});
