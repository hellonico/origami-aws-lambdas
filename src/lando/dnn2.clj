(ns lando.dnn2
    (:require 
        [origami-dnn.net.yolo :as yolo]
        [opencv4.core :refer :all]
        [opencv4.utils :as u]
        [opencv4.dnn.core :as origami-dnn]
        [cheshire.core :refer [generate-string]])
    (:gen-class
      :methods [^:static [handler [java.util.List] String]]))

(let [[net opts labels] (origami-dnn/read-net-from-repo "networks.yolo:yolov2-tiny:1.0.0")]

    (defn result! [result labels]
    (let [img (first result) detected (second result)]
        (doall (map #(let [{confidence :confidence label :label box :box} %]
        {:label (nth labels label) :confidence confidence }) detected))))

    (defn run-yolo [ input ]
        (println "Running yolo on image:" input)
        (-> input
            (u/mat-from-url)
            (yolo/find-objects net)
            (result! labels))))
  
(defn -handler [s]
    (generate-string (doall (map run-yolo s))))