def call() {
  sh '''docker pull semgrep/semgrep && \
            docker run \
            -e SEMGREP_APP_TOKEN=$SEMGREP_APP_TOKEN \
            -v "$(pwd):$(pwd)" --workdir $(pwd) \
            semgrep/semgrep  \
            sh \
            -c "echo "apk update && \
            apk add openjdk8 maven && \
            semgrep ci --allow-local-builds"
     '''
}
