(ns pokedex.diplomat.http_server
  :require [io.pedestal.http.route :refer [expand-routes]
           [ring.util.response :as ring-resp]])

(defn current-version
      [request]
      (ring-resp/response "Hello World!!"))

(def default-routes
  #{["/api/version"
     :get current-version
     :route-name :version]})

(def routes
  (expand-routes
   (set/union
    default-routes)))