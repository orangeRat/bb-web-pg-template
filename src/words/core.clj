(ns words.core
  (:require [words.server :as serv]))

(defn -main [& args]
  (serv/run)
  @(promise)) ;; wait until SIGINT

