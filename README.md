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

### Building and uploading release

```bash
gradle jar
gh release create --prerelease --notes '' --title '' v0.1
gh release upload --clobber v0.1 app/build/libs/app.jar
```
