(ns pomjars.core
  (:require [cemerick.pomegranate :refer [add-dependencies]]))

(defn add-deps [& deps]
  (add-dependencies
   :coordinates deps
   :repositories (merge cemerick.pomegranate.aether/maven-central
                        {"clojars" "http://clojars.org/repo"})))
