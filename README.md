# Pomjars: Pomegranate for the lazy and forgetful

Pomegranate is awesome. With it, humanity has made great progress towards having a monotonically increasing number of Cider sessions in Emacs. There are just two problems with it:

* It's never a part of the project when you need it.
* You need to copy and paste from its README every time you actually want to use it.

Pomjars solves these problems. Actually, Leiningein solves the first problem when you install Pomjars, but Pomjars totally solves the second problem.

To install Pomjars, run `lein repl` in your home directory and evaluate the following code:

```clojure
(->> (with-out-str
       (-> (clojure.edn/read-string (slurp ".lein/profiles.clj"))
           (update-in [:user :dependencies]
                      (fn [coll x]
                        (if coll (conj coll x) [x]))
                      '[edw/pomjars "0.1.0"])
           clojure.pprint/pprint))
     (spit ".lein/profiles.clj.new"))
```

Review the generated file `profiles.clj.new` and replace the original `profiles.clj` when you're happy. Now, whenever you're running a REPL and realize you forget to add a bunch of stuff to your `project.clj`, you can simply do this:

```clojure
(require '[pomjars.core :as pj])
(pj/add-deps '[incanter "1.2.3"] '[clj-http "0.7.8"])
```

And boom, Pomegranate searches Maven Central as well as Clojars.org for the given dependencies and resolves them, so you can get back to having fun.
