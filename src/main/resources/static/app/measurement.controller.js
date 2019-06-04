/**
 * Created by dan.geabunea on 3/29/2016.
 */
(function () {
    'use strict';

    angular
        .module('app')
        .controller('MeasurementControler', MeasurementControler);

    MeasurementControler.$inject = ['$http'];

    function MeasurementControler($http) {
        var vm = this;

        vm.measurements = [];
        vm.getAll = getAll;

        init();

        function init(){
            getAll();
        }
        function getAll(){
            var url = "/apiv1/get-all";
            var measurementPromise = $http.get(url);
            measurementPromise.then(function(response){
                vm.measurements = response.data;
            });
        }
    }
})();
