def call() {
  sh '''docker pull semgrep/semgrep && \
            docker run \
            -e SEMGREP_APP_TOKEN=$SEMGREP_APP_TOKEN \
            -v "$(pwd):$(pwd)" --workdir $(pwd) \
            semgrep/semgrep  \
            echo "https://dl-cdn.alpinelinux.org/alpine/edge/testing" >>/etc/apk/repositories
            apk update && \
            apk add openjdk23-jdk maven && \
            semgrep ci --allow-local-builds 
     '''
}
