/**
 * Created by Pulkit on 16-Dec-16.
 */


var example = (function () {
    "use strict";

    var scene = new THREE.Scene(),
        renderer = Window.WebGLRenderingContext ? new THREE.WebGLRenderer({antialias: true}) : new THREE.CanvasRenderer(),
        light = new THREE.AmbientLight(0xffffff),
        camera, box, stats, monster, dirLight, hemiLight;

    function initScene() {
        renderer.setSize(900, 600);
        document.getElementById("content").appendChild(renderer.domElement);

        //scene.add(light);

        //set fog
        scene.fog = new THREE.Fog(0xffffff, 1, 5000);
        scene.fog.color.setHSL(0.6, 0, 1);

        // LIGHTS
        hemiLight = new THREE.HemisphereLight(0xffffff, 0xffffff, 0.6);
        hemiLight.color.setHSL(0.6, 1, 0.6);
        hemiLight.groundColor.setHSL(0.095, 1, 0.75);
        hemiLight.position.set(0, 500, 0);
        scene.add(hemiLight);
        //
        dirLight = new THREE.DirectionalLight(0xffffff, 1);
        dirLight.color.setHSL(0.1, 1, 0.95);
        dirLight.position.set(-1, 1.75, 1);
        dirLight.position.multiplyScalar(50);
        scene.add(dirLight);
        dirLight.castShadow = true;
        dirLight.shadow.mapSize.width = 2048;
        dirLight.shadow.mapSize.height = 2048;
        var d = 50;
        dirLight.shadow.camera.left = -d;
        dirLight.shadow.camera.right = d;
        dirLight.shadow.camera.top = d;
        dirLight.shadow.camera.bottom = -d;
        dirLight.shadow.camera.far = 3500;
        dirLight.shadow.bias = -0.0001;
        // GROUND
        var groundGeo = new THREE.PlaneBufferGeometry(10000, 10000);
        var groundMat = new THREE.MeshPhongMaterial({color: 0xffffff, specular: 0x050505});
        groundMat.color.setHSL(0.095, 1, 0.75);
        var ground = new THREE.Mesh(groundGeo, groundMat);
        scene.add(ground);
        ground.receiveShadow = true;

        // SKYDOME
        var vertexShader = document.getElementById('vertexShader').textContent;
        var fragmentShader = document.getElementById('fragmentShader').textContent;
        var uniforms = {
            topColor: {value: new THREE.Color(0x0077ff)},
            bottomColor: {value: new THREE.Color(0xffffff)},
            offset: {value: 33},
            exponent: {value: 0.6}
        };
        uniforms.topColor.value.copy(hemiLight.color);
        scene.fog.color.copy(uniforms.bottomColor.value);
        var skyGeo = new THREE.SphereGeometry(4000, 32, 15);
        var skyMat = new THREE.ShaderMaterial({
            vertexShader: vertexShader,
            fragmentShader: fragmentShader,
            uniforms: uniforms,
            side: THREE.BackSide
        });
        var sky = new THREE.Mesh(skyGeo, skyMat);
        scene.add(sky);


        camera = new THREE.PerspectiveCamera(
            35,
            900 / 600,
            1,
            1000
        );

        camera.position.z = 150;
        camera.position.y = 20;
        camera.rotation.x = -0.1;
        scene.add(camera);

        box = new THREE.Mesh(
            new THREE.BoxGeometry(20, 20, 20),
            new THREE.MeshLambertMaterial({color: 0xff0000})
        );

        box.name = "box";
        //scene.add(box);

        //setup loader
        var loader = new THREE.ColladaLoader();
        loader.options.convertUpAxis = true;

        // //add geometry
        // loader.load("../models/monster/monster.dae", function (collada) {
        //     monster = collada.scene;
        //     scene.add(monster);
        //     render();
        // });

        //add geometry
        loader.load("../models/avatar.dae", function (collada) {
            monster = collada.scene;
            scene.add(monster);
        });

        //shows stats
        stats = new Stats();
        stats.setMode(0);
        stats.domElement.style.position = "relative";
        stats.domElement.style.left = "0px";
        stats.domElement.style.top = "0px";
        stats.domElement.style.margin = "10px";
        document.getElementById("controls").appendChild(stats.domElement);
        //scene.background = new THREE.Color(0xffffff);


        //renderer

        renderer.setClearColor(scene.fog.color);
        renderer.setPixelRatio(window.devicePixelRatio);
        renderer.gammaInput = true;
        renderer.gammaOutput = true;
        renderer.shadowMap.enabled = true;
        renderer.shadowMap.renderReverseSided = false;

        render();
    }


    function render() {
        box.rotation.y += 0.01;
        if (monster !== undefined) {
            monster.rotation.y += 0.01;
        }
        renderer.render(scene, camera);
        requestAnimationFrame(render);
        stats.update();
    }

    window.onload = initScene;

    return {
        scene: scene
    };
})();