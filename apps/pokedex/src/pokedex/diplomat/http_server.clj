(ns pokedex.diplomat.http_server
  (:require [io.pedestal.http.body-params :as body-params]
            [io.pedestal.http :as http]
            [ring.util.response :as ring-resp]))

(def common-interceptors [(body-params/body-params) http/html-body])

(defn current-version
      [request]
      (ring-resp/response "Oi"))

(defn home
  [request]
  (ring-resp/response "you are on home!"))

(def default-routes
  #{["/"
     :get (conj
            common-interceptors
            home)
     :route-name :home]
    ["/api/version"
     :get (conj
            common-interceptors
            current-version)
     :route-name :version]})

; TODO: Refactor this
#_ (def routes
  (expand-routes
   (set/union
    default-routes)))