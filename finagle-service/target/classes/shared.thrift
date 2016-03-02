namespace java lvsong.club.thrift.shared

struct SharedStruct {
    1: i32 key,
    2: string value
}

service SharedService {
    SharedStruct getStruct(1: i32 key)
}