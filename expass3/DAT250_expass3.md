# Expass 3 Mongo DB - Jørn-Are Flaten - 240425 

I installed MongoDb as a service on Windows and installed the Mongosh shell without compass and therefore I use the MongoDB shell language for all the assignments, as seen in the screenshots. No technical problems encountered during installation.

Verification of GPG signature was done with slight modifications to the Powershell script provided to match my local directory. Screenshot is provided. 

## Ex 1
Fairly straight forward with copy pasting the commands to play with them. Did complete this in my own shell on my local machine and did not really experience any problems. Noticed that ```db.pizzas.insertMan(..)``` would not insert fields into a database i had not already created, so i had to ```use pizzas``` to switch to that database before re-running the command. This bulk operation and examples of Inserts, queries, update, delete operations found in the provided screenshots. 


# Ex 2 

Following the tutorials was fairly straight forward and didn't really bring any special challenges. I completed both the aggregations and map reduce and created my own queries for both. The results can be seen in the provided screenshots, and the map reduce code can be found below. Here i wanted to find all the chocolates  in the orders and count the quantity. Working with Javascript isn't something i do every full moon so this was a little tricky, but not too hard. I took a shortcut and provided a default value for the cases that werent chocolates as i couldn't see a simple solution to handle the undefined/null objects. (seen in the myMapFunction1()). This means that this is also written to the file, but as i don't see a way to filter out the _id i don't want as the map functions are taking the returning map value of the previous function as argument, i will leave it like this. This function can be useful if you want to see how many chocolates have been ordered. The sku value could of course be exchanged for any other like apples or oranges. 


Curious as to why we focus on Map-Reduce when it is deprecated as of MongoDB 5.0 in favor of aggregations. 


```javascript
var myMapFunction1 = function() {
    for (var i = 0; i < this.items.length; i++) {
        var s = this.items[i].sku
        if(s == 'chocolates') {
            var key = s;
            var value = { qty: this.items[i].qty };
        } else 
        {
            var key = "Not a chocolate"
            var value = 0 
        }
       emit(key, value);
    }
};
```



```javascript
var myReduceFunction1 = function(item, quantity) {
    chocos = {qty: 0}
    for (var i = 0; i < quantity.length; i++) {     
        chocos.qty += quantity[i].qty
    }
    return chocos;
};
```

```javascript
db.orders.mapReduce(myMapFunction1, myReduceFunction1, { out: "all_my_chocolates" } )
```

