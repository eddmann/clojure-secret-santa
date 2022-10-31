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

## Other Years

Interested in seeing how I over-engineered the problem of allocating Secret Santa's in other years?

- 2020 - [Clojure Secret Santa](https://github.com/eddmann/clojure-secret-santa)
- 2021 - [Pico Secret Santa](https://github.com/eddmann/pico-secret-santa)
- 2022 - [Step Function Secret Santa](https://github.com/eddmann/step-function-secret-santa)
