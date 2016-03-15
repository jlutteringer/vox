(ns alloy.three.main
  (:require [cljsjs.three]))


(def camera
  (THREE/PerspectiveCamera.
    75
    (/ 800 600)
    1
    10000))

(set! (.-z (.-position camera)) 1000)

(def scene (THREE/Scene.))
(def geometry (THREE/CubeGeometry. 400 400 400))
(def obj (js/Object.))

(set! (.-color obj) 0xff0000)
(set! (.-wireframe obj) true)

(def material (THREE/MeshBasicMaterial. obj))
(def mesh (THREE/Mesh. geometry material))
(def renderer (THREE/WebGLRenderer.))

(.add scene mesh)

(.setSize renderer 800 600)

(.appendChild
  (.getElementById
    js/document
    "main-arena")
  (.-domElement renderer))

(set! (.-dynamic (.-geometry mesh)) true)

(defn render []
  (set! (.-x (.-rotation mesh)) (+ (.-x (.-rotation mesh)) 0.01))
  (set! (.-y (.-rotation mesh)) (+ (.-y (.-rotation mesh)) 0.02))
  (set! (.-verticesNeedUpdating (.-geometry mesh)) true)
  (set! (.-normalsNeedUpdating (.-geometry mesh)) true)
  (.render renderer scene camera))

(defn animate []
  (.requestAnimationFrame js/window animate)
  (render))

(animate)