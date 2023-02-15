# java-jetty

## Datadog  - [Injecting Libraries](https://docs.datadoghq.com/tracing/trace_collection/library_injection/?tab=host)

This is a MUCH simplified script to test Datadog's new injection of tracing libraries. It was tested on an Ubuntu 20.04 LTS and it assumes you have the Datadog agent installed and with APM enabled.

```bash
sudo apt-get install datadog-apm-inject datadog-apm-library-java
dd-host-install
export DD_CONFIG_SOURCES=BASIC
wget https://github.com/yafernandes/java-jetty/releases/latest/download/app.jar
java -jar app.jar
```

In another shell, generate some traffic...
```bash
curl localhost:9090/hello/world
```

You should see the line below indicating that the instrumentation was successful.

```
[dd.trace 2023-02-15 14:00:00:508 +0000] [dd-task-scheduler] INFO datadog.trace.agent.core.StatusLogger - DATADOG TRACER CONFIGURATION {"version":"1.6.0~c256ff8259","os_name":"Linux","os_version":"5.15.0-1033-azure","architecture":"amd64","lang":"jvm","lang_version":"11.0.17","jvm_vendor":"Ubuntu","jvm_version":"11.0.17+8-post-Ubuntu-1ubuntu220.04","java_class_version":"55.0","http_nonProxyHosts":"null","http_proxyHost":"null","enabled":true,"service":"app","agent_url":"http://localhost:8126","agent_unix_domain_socket":"/opt/datadog/apm/inject/run/apm.socket","agent_error":false,"debug":false,"analytics_enabled":false,"sample_rate":1.0,"sampling_rules":[{},{}],"priority_sampling_enabled":true,"logs_correlation_enabled":true,"profiling_enabled":false,"remote_config_enabled":true,"debugger_enabled":false,"appsec_enabled":"ENABLED_INACTIVE","telemetry_enabled":true,"dd_version":"","health_checks_enabled":true,"configuration_file":"no config file present","runtime_id":"5d1c313f-074f-4d2b-b910-f4af83469b53","logging_settings":{"levelInBrackets":false,"dateTimeFormat":"'[dd.trace 'yyyy-MM-dd HH:mm:ss:SSS Z']'","logFile":"System.err","configurationFile":"simplelogger.properties","showShortLogName":false,"showDateTime":true,"showLogName":true,"showThreadName":true,"defaultLogLevel":"INFO","warnLevelString":"WARN","embedException":false},"cws_enabled":false,"cws_tls_refresh":5000,"datadog_profiler_enabled":true,"datadog_profiler_safe":true}
```

### Build and release upload

```bash
gradle jar
VERSION=v0.1
gh release create --notes '' --title '' $VERSION
gh release upload --clobber $VERSION app/build/libs/app.jar
```
