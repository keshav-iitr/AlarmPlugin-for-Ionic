var alarm = {
    set: function(alarmDate,alarmid,message,successCallback, errorCallback) {
        if(alarmDate < new Date())
    		return;
    	
        cordova.exec(
            successCallback,
            errorCallback,
            "AlarmPlugin",
            "programAlarm",
            [alarmDate,alarmid,message]
        );
    },
    stop: function(alarmid, successCallback, errorCallback) {
        
        cordova.exec(
            successCallback,
            errorCallback,
            "AlarmPlugin",
            "stopAlarm",
            [alarmid]
        );
    }
};
module.exports = alarm;
