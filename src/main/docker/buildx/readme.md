###docker buildx
    
    docker buildx build --platform linux/arm,linux/arm64,linux/amd64 -t qingfeng2336/aoonav --push -f ./Dockerfile .