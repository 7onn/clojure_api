sudo apt-get update
sudo apt install docker.io
sudo systemctl start docker
sudo systemctl enable docker
cd /home
git clone https://github.com/devbytom/clojure_api app
cd app
docker build -t webhook .
docker run -d -p 80:3000 webhook:latest