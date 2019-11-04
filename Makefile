IMAGE := clojure:lein
DOCKER := docker run --rm -it -v $(PWD):/src -w /src
RUN := $(DOCKER) $(IMAGE)

.PHONY: build
build:
	$(RUN) lein uberjar

.PHONY: test
test:
	$(RUN) lein test

.PHONY: fmt
fmt:
	$(RUN) lein cljfmt fix

.PHONY: shell
shell:
	$(RUN) bash
