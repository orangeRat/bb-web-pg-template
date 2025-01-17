(ns words.db
  :require [pod.babashka.postgresql :as pg])


(def db {:dbtype   "postgresql"
         :host     "localhost"
         :dbname   "cards"
         :user     "postgres"
         :password "123"
         :port     5432})

(defn request
  []
  (pg/execute! db ["select * from word"]))

