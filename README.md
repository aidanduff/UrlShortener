Url Shortener for Technical Assessment

The endpoints:

    "/" Start page.
    
    "/squeez.it" Plain text POST requests in the request body will return a JSON object containing the shortened URL.
    
    "/squeeze.it/" Append the shortened URL to this endpoint and send a GET request to be redirected to the original linked page.
    
    "/stats" Some statistics on the current state of the running application.
