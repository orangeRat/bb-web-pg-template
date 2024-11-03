(ns words.server
  (:require [clojure.pprint :refer [pprint]]
            [org.httpkit.server :as server]
            [cheshire.core :as json]))

;; :uri :body :request-method :headers :query-string

(defn wrap-json [content]
  {:headers {"Content-type" 'application/json}
   :body (json/encode content)})

(defn handler [req]
  (wrap-json (dissoc req :async-channel)))

(defn file [req]
  (let [reply (str (slurp "src/words/core.clj")
                   "---\n\n"
                   (with-out-str (pprint (dissoc req
                                                 :headers
                                                 :async-channel))))]
    {:body reply}))

(defn run []
  (server/run-server #'handler {:port 8090}))

