(ns lando.dnn
    (:require 
        [origami-dnn.net.yolo :as yolo]
        [opencv4.core :refer :all]
        [opencv4.utils :as u]
        [opencv4.dnn.core :as origami-dnn])
    (:gen-class
      :methods [^:static [handler [String] String]]))

(defn result! [result labels]
(let [img (first result) detected (second result)]
    (map #(let [{confidence :confidence label :label box :box} %]
    {:label (nth labels label) :confidence confidence }) detected)))

(defn run-yolo [ input ]
(let [[net opts labels] (origami-dnn/read-net-from-repo "networks.yolo:yolov2-tiny:1.0.0")]
    (println "Running yolo on image:" input)
    (-> input
        (u/mat-from-url)
        (yolo/find-objects net)
        (result! labels))))
  
(defn -handler [s]
   (apply str (run-yolo s)))