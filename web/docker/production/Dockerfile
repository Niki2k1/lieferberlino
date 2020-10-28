FROM nginx:alpine

COPY . /opt/lieferberlino

WORKDIR /opt/lieferberlino

RUN apk update &&\
    apk add --update --virtual build_deps npm &&\
    npm install && npm run build &&\
    mv /opt/lieferberlino/dist/* /usr/share/nginx/html &&\
    apk del build_deps && \
    rm -rf /opt/lieferberlino

EXPOSE 80