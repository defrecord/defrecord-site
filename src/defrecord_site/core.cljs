(ns defrecord-site.core
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))

(enable-console-print!)

(println "defrecord-site")

;; define your app data so that it doesn't get over-written on reload

(defonce app-state (atom {:title "defrecord"}))

(om/root
  (fn [data owner]
    (reify om/IRender
      (render [_]
        (dom/h1 nil (:title data)))))
  app-state
  {:target (. js/document (getElementById "app"))})

(defn on-js-reload [])
