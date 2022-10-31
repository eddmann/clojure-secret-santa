# Clojure Secret Santa

Allocates and emails secret santa's (using Gmail).

## Usage

```
name,email,exclude,gender
Bob,bob@email.com,Jim,m
Sally,sally@email.com,Jane,f
...
```

`GMAIL_USERNAME=x GMAIL_PASSWORD=x java -jar secret-santa-1.0.0-standalone.jar participants.txt`
