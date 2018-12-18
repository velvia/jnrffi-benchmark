#[repr(C)]
pub struct vector_type {
    major_type: u8,    // These should probably be enums no?
    minor_type: u8
}

#[no_mangle]
pub extern fn double_input(input: i32) -> i32 {
    input * 2
}

// TODO: add the following functions:
//   allocate a new BinaryVector
//   read a long from it
//   append a long to it