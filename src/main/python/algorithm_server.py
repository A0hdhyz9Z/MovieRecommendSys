import grpc
import example_pb2
import example_pb2_grpc

class GreeterServicer(example_pb2_grpc.GreeterServicer):
    def SayHello(self, request, context):
        response = example_pb2.HelloReply()
        response.message = f"Hello, {request.name}!"
        return response

server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
example_pb2_grpc.add_GreeterServicer_to_server(GreeterServicer(), server)
server.add_insecure_port("[::]:50051")
server.start()

print("Server started, listening on port 50051")
server.wait_for_termination()
