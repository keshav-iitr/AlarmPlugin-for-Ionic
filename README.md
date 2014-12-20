AlarmPlugin2
============

How to use
------------------

     $ cordova plugin add  https://github.com/keshav-iitr/AlarmPlugin2.git

     $ cordova prepare
     
     then
     
     navigator.plugins.alarm.set(alarmDate,alarmid,message, 
          function(){
            // SUCCESS
          }, 
          function(){
            // ERROR
          })
     
     
      navigator.plugins.alarm.stop(alarmid, 
          function(){
            // SUCCESS
          }, 
          function(){
            // ERROR
          })
          
     
How to remove
---------------

    $ cordova plugin rm com.kk.alarmplugin
    
    or
    
    $ cordova plugin remove com.kk.alarmplugin
