(ns webapp.core
  (:require [reagent.dom :as r.dom]
            [clojure.string :as str]
            [reagent.core :as r]))



(defonce timer (r/atom (js/Date.)))
(defonce time-color (r/atom "#888"))

(defonce time-updater (js/setInterval
                       #(reset! timer (js/Date.)) 1000))

(defn clock []
  (let [time-str (-> @timer .toTimeString (str/split " ") first)]
    [:div.example-clock
     {:style {:color @time-color}}
     time-str]))

(defn app []
  [:div
   [clock]
   [:h1 "MyWeb3 Example"]
   [:h2 "Wallets"]])







(r.dom/render [app] (js/document.getElementById "app"))
